package me.abbah.openlab.microservices.billing.services;

import me.abbah.openlab.microservices.billing.dto.InvoiceRequestDTO;
import me.abbah.openlab.microservices.billing.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO store(InvoiceRequestDTO dto);

    InvoiceResponseDTO getInvoice(String invoiceId);

    List<InvoiceResponseDTO> customerInvoices(String customerId);

    List<InvoiceResponseDTO> getAllInvoices();
}
