package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Banners
import com.example.kotlindemo.repository.BannersRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BannersController(private val bannersRepository: BannersRepository){

    @GetMapping("/banner")
    fun getAllBanner(): List<Banners> = bannersRepository.findAll()

        @GetMapping("banner/{id}")
        fun getBannerById(@PathVariable(value = "id")bannerId:Long): ResponseEntity<Banners>{
            return bannersRepository.findById(bannerId).map {
                banner -> ResponseEntity.ok(banner)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PostMapping("/banner")
        fun createNewBanner(@Valid @RequestBody banners: Banners): Banners = bannersRepository.save(banners)

        @PutMapping("/banner/{id}")
        fun updateBannerById(@PathVariable(value = "id")bannerId: Long,
                             @Valid @RequestBody newBanners: Banners
        ) : ResponseEntity<Banners>{
            return bannersRepository.findById(bannerId).map {
                existingBanner -> val updateBanners: Banners = existingBanner.copy(img = newBanners.img)
                ResponseEntity.ok().body(bannersRepository.save(updateBanners))
            }.orElse(ResponseEntity.notFound().build())
        }

        @DeleteMapping("/banner/{id}")
        fun deleteBannerById(@PathVariable(value = "id") bannerId: Long): ResponseEntity<Void>{
            return bannersRepository.findById(bannerId).map {
                banner -> bannersRepository.delete(banner)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
        }


}
