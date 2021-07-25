package me.abbah.openlab.microservices.billing.services;

import me.abbah.openlab.microservices.billing.dto.InvoiceRequestDTO;
import me.abbah.openlab.microservices.billing.dto.InvoiceResponseDTO;
import me.abbah.openlab.microservices.billing.entities.Customer;
import me.abbah.openlab.microservices.billing.entities.Invoice;
import me.abbah.openlab.microservices.billing.mappers.InvoiceMapper;
import me.abbah.openlab.microservices.billing.openfeign.CustomerRestClient;
import me.abbah.openlab.microservices.billing.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;
    private final InvoiceMapper mapper;
    private final CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository repository, InvoiceMapper mapper, CustomerRestClient customerRestClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO store(InvoiceRequestDTO dto) {
        Invoice invoice = mapper.toInvoice(dto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice = repository.save(invoice);
        return mapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = repository.getById(invoiceId);
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);

        return mapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> customerInvoices(String customerId) {
        Customer customer = customerRestClient.getCustomer(customerId);
        return repository
                .findByCustomerId(customerId)
                .stream()
                .map(invoice -> {
                    invoice.setCustomer(customer);
                    return mapper.fromInvoice(invoice);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        return repository
                .findAll()
                .stream()
                .map(invoice -> {
                    Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
                    invoice.setCustomer(customer);
                    return mapper.fromInvoice(invoice);
                })
                .collect(Collectors.toList());
    }
}
