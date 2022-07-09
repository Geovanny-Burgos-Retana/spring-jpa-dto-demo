package moovin.springarchetype.controller;


import lombok.extern.log4j.Log4j2;
import moovin.springarchetype.domain.Entity;
import moovin.springarchetype.dto.EntityRequest;
import moovin.springarchetype.dto.EntityResponse;
import moovin.springarchetype.dto.TestRequest;
import moovin.springarchetype.dto.TestResponse;
import moovin.springarchetype.service.EntityService;
import moovin.springarchetype.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
@RequestMapping("/archetype/api/v1")
public class ApiController {
  private final OtherService otherService;
  private final EntityService entityService;


  @Autowired
  public ApiController(OtherService otherService, EntityService entityService) {
    this.otherService = otherService;
    this.entityService = entityService;
  }

  @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<TestResponse> testPost(@RequestBody TestRequest testRequest, HttpServletRequest request) {
    log.warn("NEW REQUEST - HTTP request on resource mapping \"/test\" - IP: " + request.getHeader("X-FORWARDED-FOR"));
    HttpStatus httpStatus = HttpStatus.OK;
    TestResponse response = new TestResponse();
    response.setStatus("OK");
    response.setMessage("Received message: " + testRequest.getMessage());
    System.out.println(testRequest);
    return new ResponseEntity<>(response, httpStatus);
  }

  @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<TestResponse> testGet(HttpServletRequest request) {
    log.warn("NEW REQUEST - HTTP request on resource mapping \"/test\" - IP: " + request.getHeader("X-FORWARDED-FOR"));
    HttpStatus httpStatus = HttpStatus.OK;
    TestResponse response = new TestResponse();
    response.setStatus("OK");
    response.setMessage("Hello world!");
    return new ResponseEntity<>(response, httpStatus);
  }

  @PostMapping(value = "/entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<EntityResponse> createEntity(@RequestBody EntityRequest entityRequest, HttpServletRequest request) {
    log.warn("NEW REQUEST - HTTP request on resource mapping \"/entity\" - IP: " + request.getHeader("X-FORWARDED-FOR"));
    HttpStatus httpStatus = HttpStatus.OK;
    EntityResponse response = new EntityResponse();
    if(entityRequest.getName() != null) {
      Entity entity = new Entity();
      entity.setName(entityRequest.getName());
      entityService.createEntity(entity);
      response.setStatus("OK");
      response.setMessage("New Entity created");
      response.setEntityName(entity.getName());
    } else {
      response.setStatus("ERROR");
      response.setMessage("Failed to parse name. Please check your json body");
      response.setEntityName("-");
      httpStatus = HttpStatus.BAD_REQUEST;
    }
    return new ResponseEntity<>(response, httpStatus);
  }

  @GetMapping(value = "/entity", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<EntityResponse> createEntity(@RequestParam String name, HttpServletRequest request) {
    log.warn("NEW REQUEST - HTTP request on resource mapping \"/entity\" - IP: " + request.getHeader("X-FORWARDED-FOR"));
    HttpStatus httpStatus = HttpStatus.OK;
    EntityResponse response = new EntityResponse();
    Entity entity = entityService.findEntityByName(name);
    if(entity != null && name != null) {
      response.setStatus("OK");
      response.setMessage("Successfully fetched an entity");
      response.setEntityName(entity.getName());
    } else {
      response.setStatus("ERROR");
      response.setMessage("Failed to fetch requested entity");
      response.setEntityName("-");
      httpStatus = HttpStatus.BAD_REQUEST;
    }
    return new ResponseEntity<>(response, httpStatus);
  }


}
