package com.example.payroll

import org.springframework.web.bind.annotation.*
import java.util.function.Function


@RestController
internal class EmployeeController(private val repository: EmployeeRepository) {


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    fun all(): MutableList<Employee?> {
        return repository.findAll()
    }

    // end::get-aggregate-root[]
    @PostMapping("/employees")
    fun newEmployee(@RequestBody newEmployee: Employee): Employee {
        return repository.save(newEmployee)
    }

    // Single item
    @GetMapping("/employees/{id}")
    fun one(@PathVariable id: Long): Employee {
        return repository.findById(id).orElseThrow { EmployeeNotFoundException(id) }
    }

    @PutMapping("/employees/{id}")
    fun replaceEmployee(@RequestBody newEmployee: Employee, @PathVariable id: Long): Employee {
        return repository.findById(id)
            .map { employee ->
                employee.name = newEmployee.name
                employee.role = newEmployee.role
                repository.save(employee)
            }
            .orElseGet {
                newEmployee.id = id
                repository.save(newEmployee)
            }
    }

    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long) {
        repository.deleteById(id)
    }
}