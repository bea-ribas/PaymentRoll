package PaymentRollDAO;

import java.util.List;

import PaymentRollModel.Funcionario;

public interface FuncionarioInterface 
{
	//public List<Funcionario> funcionarios =  new ArrayList<Funcionario>();

	public boolean SalvarFuncionario(Funcionario funcionario);
   
    
    public  Funcionario BuscarFuncionarioCpf(Funcionario funcionario);
    

    public  List<Funcionario> RetornarLista();
    
}