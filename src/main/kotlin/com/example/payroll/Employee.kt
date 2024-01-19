package com.example.payroll

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
internal class Employee {
    @Id
    @GeneratedValue
    var id: Long? = null
    var name: String? = null
    var role: String? = null

    constructor()

    constructor(name: String?, role: String?) {
        this.name = name
        this.role = role
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is Employee) return false
        val employee = o
        return this.id == employee.id && (this.name == employee.name) && (this.role == employee.role)
    }

    override fun hashCode(): Int {
        return Objects.hash(this.id, this.name, this.role)
    }

    override fun toString(): String {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}'
    }
}