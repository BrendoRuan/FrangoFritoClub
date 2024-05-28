package com.FrangoFrito.FrangoFrito.Controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImagemControler {


    @PostMapping("/enviar")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file selected for upload.");
        }

        try {
            // Define o caminho onde o arquivo será salvo
            String uploadDir = "src/main/resources/static/imagem/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // Salva o arquivo no diretório especificado
            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");
        }
    }
/*
    @GetMapping("/imagem")
    public String showImage() {
        return "imagem";
    }

/*
    @Autowired
    private ImagemService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Imagem savedImagem = imageService.saveImagem(file);
            return ResponseEntity.ok("Image uploaded successfully: " + savedImagem.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable Long id) {
        Optional<Imagem> imagemOptional = imageService.getImageById(id);

        if (imagemOptional.isPresent()) {
            Imagem imagem = imagemOptional.get();
            ByteArrayResource resource = new ByteArrayResource(imagem.getData());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(imagem.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + imagem.getName() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}