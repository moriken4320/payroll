package com.example.payroll

import org.springframework.data.jpa.repository.JpaRepository
internal interface EmployeeRepository : JpaRepository<Employee, Long>
