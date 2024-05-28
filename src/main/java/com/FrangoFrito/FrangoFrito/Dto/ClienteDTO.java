package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Cliente;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class ClienteDTO extends PessoaDTO {
    private boolean statusCliente;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }

    public ClienteDTO(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }

    public boolean getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }
}