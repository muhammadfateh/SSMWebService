package com.management.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.ssm.model.Customer;
import com.management.ssm.repository.customerRepository;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.json.JSONObject;

import org.omg.CORBA.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@CrossOrigin
//@RestController
//@RequestMapping(value = "/image")
@Component
public class imageController {
    private String directorypath = "E:\\Faltu Setup\\Tutorials\\Angular.JS Learning Path\\Youtube Tutorials\\Pratices(ANGULAR)\\Project\\src\\assets\\Images\\ItemIcons";
    private Logger log = LoggerFactory.getLogger(Image.class);

    /*@GetMapping(value = "{id}")
    public @ResponseBody
    Object getFile(@PathVariable long id) {
        Image image = imagerepository.findOne(id);
        return image;
        //return null;
    }
*/
    /*@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String insertImage(@RequestParam("file")  MultipartFile file) throws IOException {
        Image image=new Image();
        image.setIMAGE_DATA(file.getBytes());
        imagerepository.saveAndFlush(image);
        return image.toString();
    }*/
    //   @CrossOrigin(origins = "http://localhost:4200")
    //@PostMapping
    /*public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy-hhmmss");
        Date date = new Date();
        String fileName = "";
        if (!file.isEmpty()) {
            try {
                String[] split = file.getOriginalFilename().split("\\.");
                String ext = split[split.length - 1];
                fileName = "File-" + dateFormat.format(date) + "." + ext;
                log.info(file.getName());
                log.info(file.getContentType());
                log.info(file.getOriginalFilename());
                log.info(fileName);
                if (Files.notExists(Paths.get(directorypath), LinkOption.NOFOLLOW_LINKS)) {
                    Files.createDirectory(Paths.get(directorypath));
                    log.debug("I am entered.");
                }
                Files.copy(file.getInputStream(), Paths.get(directorypath + "/" + fileName));
            } catch (IOException | RuntimeException e) {
                return e.getMessage();
            }
        }
        return fileName;
    }

    @GetMapping
    public byte[] getImage(@RequestBody String data) throws IOException {
        JSONObject object = new JSONObject(data);
        if (object.has("path"))
            return Files.readAllBytes(Paths.get(object.getString("path")));
        else
            return null;
    }*/
}
