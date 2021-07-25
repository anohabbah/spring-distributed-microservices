package me.abbah.openlab.microservices.billing.mappers;

import me.abbah.openlab.microservices.billing.dto.InvoiceRequestDTO;
import me.abbah.openlab.microservices.billing.dto.InvoiceResponseDTO;
import me.abbah.openlab.microservices.billing.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice toInvoice(InvoiceRequestDTO dto);

    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
