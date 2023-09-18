package com.example.kotlindemo.repository


import com.example.kotlindemo.model.entity.Banners
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BannersRepository : JpaRepository<Banners,Long>
