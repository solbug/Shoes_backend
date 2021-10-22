package com.shoes.controller;

import com.shoes.service.IBrandService;
import com.shoes.vo.BrandVO;
import com.shoes.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    IBrandService brandService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(  @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                      @RequestParam(name = "size", required = false, defaultValue = "5") Integer size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return  ResponseEntity.status(HttpStatus.OK).body( brandService.findAll(pageable));
    }

    @PostMapping("/save-brand")
    public ResponseEntity<?> saveBrand(@RequestBody BrandVO BrandVO){
        return  ResponseEntity.status(HttpStatus.CREATED).body(brandService.save(BrandVO));
    }
    @PostMapping("/update-brand")
    public ResponseEntity<?> UpdateBrand(@RequestBody BrandVO BrandVO){
        return  ResponseEntity.status(HttpStatus.CREATED).body(brandService.save(BrandVO));
    }
    @DeleteMapping("/delete-brand/{id}")
    public ResponseEntity<?> deleteBlackList(@PathVariable("id") Integer id){
        brandService.deleteBrandById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageVO("Xóa thành công"));
    }
    @GetMapping("/searchFullName")
    public ResponseEntity<?> searchFullNamePatient(@RequestParam (name = "name", required = true) String name,
                                                               @RequestParam (name = "id", required = false) String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.search(name, id));
    }
}
