package com.FrangoFrito.FrangoFrito.Dto;

import com.FrangoFrito.FrangoFrito.Entity.Funcionario;
import org.springframework.beans.BeanUtils;

public class FuncionarioDTO extends PessoaDTO{
    private boolean StatusFuncionario;

    public FuncionarioDTO(){}
    public FuncionarioDTO(Funcionario funcionario){BeanUtils.copyProperties(funcionario, this);}

    public FuncionarioDTO(boolean statusFuncionario) {StatusFuncionario = statusFuncionario;}

    public boolean isStatus() {
        return StatusFuncionario;
    }

    public void setStatus(boolean status) {
        StatusFuncionario = StatusFuncionario;
    }
}
