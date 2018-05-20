package com.app.simple_payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.simple_payroll.auth.model.Group;
import com.app.simple_payroll.service.GroupService;

@RestController
public class GroupController {

  
  @Autowired
  private GroupService grpService;

  @PostMapping("/group")
  public ResponseEntity<?> save(@RequestBody Group emp) {
    long id = grpService.save(emp);
      return ResponseEntity.ok().body("New employee has been saved with ID:" + id);
  }
  
  @GetMapping("/group/{id}")
     public ResponseEntity<Group> get(@PathVariable("id") long id) {
        Group grp = grpService.get(id);
        return ResponseEntity.ok().body(grp);
     }
  
  /*---get all books---*/
     @GetMapping("/group")
     public ResponseEntity<List<Group>> list() {
        List<Group> books = grpService.list();
        return ResponseEntity.ok().body(books);
     }

     /*---Update a book by id---*/
     @PutMapping("/group/{id}")
     public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Group grp) {
       grpService.update(id, grp);
        return ResponseEntity.ok().body("Book has been updated successfully.");
     }

     /*---Delete a book by id---*/
     @DeleteMapping("/group/{id}")
     public ResponseEntity<?> delete(@PathVariable("id") long id) {
      grpService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully.");
     }

}
