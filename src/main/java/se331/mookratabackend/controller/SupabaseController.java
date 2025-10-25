package se331.mookratabackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import se331.mookratabackend.util.StorageFileDto;
import se331.mookratabackend.util.SupabaseStorageService;

public class SupabaseController {
    final SupabaseStorageService supabaseStorageService;

    public SupabaseController(SupabaseStorageService supabaseStorageService) {
        this.supabaseStorageService = supabaseStorageService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = supabaseStorageService.uploadFile(file);

            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile file) {
        try {
            StorageFileDto fileUrl =
                    supabaseStorageService.uploadImage(file);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading file: "
                    + e.getMessage());
        }
    }
}
