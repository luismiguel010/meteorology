package co.com.ceiba.meteorology;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("blob")
public class BlobController {

    @Value("${blob}")
    private Resource blobFile;

    @GetMapping
    public ResponseEntity<Resource> readBlobFile() throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=blobmeteorology.jpg");
        return new ResponseEntity<Resource>(this.blobFile, httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public void writeBlobFile(@RequestParam("data") MultipartFile data) throws IOException {
        try (OutputStream os = ((WritableResource) this.blobFile).getOutputStream()) {
            os.write(data.getBytes());
        }
    }
}
