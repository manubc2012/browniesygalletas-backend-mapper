package com.co.browniesygalletas.domain.repository;

import com.co.browniesygalletas.domain.Bill;

import java.util.List;
import java.util.Optional;

public interface BillRepository {
    List<Bill> getAll();

    Optional<List<Bill>> getByClient(String clientId);

}
