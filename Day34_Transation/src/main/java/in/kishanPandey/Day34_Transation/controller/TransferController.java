package in.kishanPandey.Day34_Transation.controller;

import in.kishanPandey.Day34_Transation.entity.TransferRecord;
import in.kishanPandey.Day34_Transation.repository.TransferRepository;
import in.kishanPandey.Day34_Transation.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(@RequestBody TransferRecord record) throws Throwable{
        transferService.transfer(record.getFromAccountId()
                , record.getToAccountId()
                , record.getAmmount());
        return ResponseEntity.ok("Done");
    }
}
