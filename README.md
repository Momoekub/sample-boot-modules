School Management System

โปรเจกต์นี้เป็น ระบบจัดการโรงเรียน ที่สร้างด้วย Spring Boot สำหรับ backend และมีการเชื่อมต่อกับ MySQL เพื่อเก็บข้อมูลของโรงเรียน ครู นักเรียน และคอร์สเรียน

Features

School CRUD – เพิ่ม แก้ไข ลบ และดูข้อมูลโรงเรียน

Teacher CRUD – เพิ่ม แก้ไข ลบ และดูข้อมูลครู

Student CRUD – เพิ่ม แก้ไข ลบ และดูข้อมูลนักเรียน

Course CRUD – เพิ่ม แก้ไข ลบ และดูข้อมูลคอร์สเรียน

Relationship

โรงเรียน (School) มี principal เป็นครู (Teacher) หนึ่งคน

ครู (Teacher) สอนหลายคอร์ส (Course)

นักเรียน (Student) อยู่ในโรงเรียน (School)

Technology Stack

Java 17+

Spring Boot

Spring Data JPA / Hibernate

MySQL

JUnit 5 สำหรับ Unit Test

Maven สำหรับจัดการ dependencies
