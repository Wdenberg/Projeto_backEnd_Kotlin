package com.example.kotlindemo.controller

import com.example.kotlindemo.model.entity.Banner
import com.example.kotlindemo.repository.BannerRepository
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
class BannerController(private val bannerRepository: BannerRepository){

    @GetMapping("/banner")
    fun getAllBanner(): List<Banner> = bannerRepository.findAll()

    @GetMapping("banner/{id}")
    fun getBannerById(@PathVariable(value = "id")bannerId:Long): ResponseEntity<Banner>{
        return bannerRepository.findById(bannerId).map {
            banner -> ResponseEntity.ok(banner)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/banner")
    fun createNewBanner(@Valid @RequestBody banner: Banner): Banner = bannerRepository.save(banner)

    @PutMapping("/banner/{id}")
    fun updateBannerById(@PathVariable(value = "id")bannerId: Long,
                         @Valid @RequestBody newBanner: Banner
    ) : ResponseEntity<Banner>{
        return bannerRepository.findById(bannerId).map {
            existingBanner -> val updateBanner: Banner = existingBanner.copy(imagem = newBanner.imagem)
            ResponseEntity.ok().body(bannerRepository.save(updateBanner))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/banner/{id}")
    fun deleteBannerById(@PathVariable(value = "id") bannerId: Long): ResponseEntity<Void>{
        return bannerRepository.findById(bannerId).map {
            banner -> bannerRepository.delete(banner)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}
