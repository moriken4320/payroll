package com.example.payroll

internal class EmployeeNotFoundException(id: Long) : RuntimeException("Could not find employee $id")
