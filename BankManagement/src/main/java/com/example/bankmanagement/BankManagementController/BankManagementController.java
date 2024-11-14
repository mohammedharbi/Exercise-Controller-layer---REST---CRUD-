package com.example.bankmanagement.BankManagementController;

import com.example.bankmanagement.ApiResponse.ApiResponse;
import com.example.bankmanagement.Model.BankManagement;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Bank-Management")
public class BankManagementController {

    ArrayList<BankManagement> bankManagements = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<BankManagement> getBankManagements() {
        return bankManagements;
    }

    @PostMapping("/add")
    public ApiResponse addBankManagement(@RequestBody BankManagement bankManagement) {
        bankManagements.add(bankManagement);
        return new ApiResponse("add successful");
    }
    @PutMapping("/update/{index}")
            public ApiResponse updateBankManagement(@PathVariable int index, @RequestBody BankManagement bankManagement) {
        bankManagements.set(index, bankManagement);
        return new ApiResponse("update successful");
    }

    @DeleteMapping("/delete/{index}")
            public ApiResponse deleteBankManagement(@PathVariable int index) {
        bankManagements.remove(index);
        return new ApiResponse("delete successful");
    }

    @PutMapping("/deposit/{index}/{amount}")
    public ApiResponse depositBankManagement(@PathVariable int index, @PathVariable double amount) {
        bankManagements.get(index).setBalance(bankManagements.get(index).getBalance() + amount);
        return new ApiResponse("deposit successful");
    }

    @PutMapping("/withdraw/{index}/{amount}")
    public ApiResponse withdrawBankManagement(@PathVariable int index, @PathVariable double amount) {
        if (bankManagements.get(index).getBalance() < amount) {return new ApiResponse("cannot withdraw balance not enough.");}
        bankManagements.get(index).setBalance(bankManagements.get(index).getBalance() - amount);
        return new ApiResponse("withdraw successful");
    }
}
