package PaymentRollModel;

import java.util.ArrayList;
import java.util.List;

public class Funcionario
{
	//List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	public String nomeFuncionario;
    public String numCpf;

    
	public String getNomeFuncionario() 
	{
		return nomeFuncionario;
	}


	public void setNomeFuncionario(String nomeFuncionario) 
	{
		this.nomeFuncionario = nomeFuncionario;
	}


	public String getNumCpf() 
	{
		return numCpf;
	}

	public void setNumCpf(String numCpf) 
	{
		this.numCpf = numCpf;
	}

	public Funcionario() 
	{
		
	} 
}