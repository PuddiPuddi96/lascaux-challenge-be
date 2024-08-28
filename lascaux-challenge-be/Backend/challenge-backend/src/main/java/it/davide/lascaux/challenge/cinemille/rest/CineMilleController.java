package it.davide.lascaux.challenge.cinemille.rest;

import io.swagger.v3.oas.annotations.Operation;
import it.davide.lascaux.challenge.cinemille.model.FilmsResponse;
import it.davide.lascaux.challenge.cinemille.model.GetFilmsByFilterRequest;
import it.davide.lascaux.challenge.cinemille.model.common.Result;
import it.davide.lascaux.challenge.cinemille.service.CineMilleService;
import it.davide.lascaux.challenge.cinemille.util.ExcelUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CineMilleController {

    private final CineMilleService cineMilleService;

    @Autowired
    public CineMilleController(CineMilleService cineMilleService) {
        this.cineMilleService = cineMilleService;
    }

    @PostMapping("/get-films-by-filter")
    @Operation(method = "POST", summary = "", description = "")
    public ResponseEntity<Result<List<FilmsResponse>>> getFilmsByFilter(
            @RequestBody GetFilmsByFilterRequest request) {

        Result<List<FilmsResponse>> response = new Result<>();

        List<FilmsResponse> result = cineMilleService.getFilmsByFilter(request);

        response.setData(result);
        response.success(HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PostMapping("/upload-films")
    @Operation(
            method = "POST",
            description = "This method enables the upload of scheduled films contained in an excel file")
    public ResponseEntity<Result<String>> uploadFilmsFromExcel(
            @RequestParam("file") MultipartFile file) {

        Result<String> response = new Result<>();
        if (ExcelUtility.hasExcelFormat(file)) {
            try {
                cineMilleService.uploadFilmsFromExcel(file);

                response.setData("The Excel file is uploaded: " + file.getOriginalFilename());
                response.success(HttpStatus.OK.value());

                return ResponseEntity.status(HttpStatus.OK).body(response);
            } catch (Exception e) {
                response.error(
                        "The Excel file is not upload: " + file.getOriginalFilename() + "!",
                        HttpStatus.EXPECTATION_FAILED.value()
                );
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
            }
        }

        response.error(
                "Please upload an excel file!",
                HttpStatus.BAD_REQUEST.value()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/get-films-history")
    @Operation(method = "GET", summary = "", description = "")
    public ResponseEntity<Result<Map<String, Object>>> getFilmsHistory(
            @RequestParam(defaultValue = "0") final Integer pageNumber,
            @RequestParam(defaultValue = "5") final Integer size
    ){
        Result<Map<String, Object>> response = new Result<>();

        Map<String, Object> result = cineMilleService.getFilmHistory(
                pageNumber,
                size
        );

        response.setData(result);
        response.success(HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
