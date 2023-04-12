package com.example.kotlindemo.repository


import com.example.kotlindemo.model.Banner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BannerRepository : JpaRepository<Banner,Long>
