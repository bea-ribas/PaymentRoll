package PaymentRollDAO;

import java.util.List;

import PaymentRollModel.FolhaDePagamento;
import PaymentRollModel.Funcionario;

public interface FolhaDePagamentoInterface 
{
			
	public void SalvarFolhaPagamento(FolhaDePagamento folhasPagamentos);

	public List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioCpf(Funcionario funcionario);

	public List<FolhaDePagamento> BuscarFolhaPagamentoFuncionarioMesAno(Funcionario funcionario,
			FolhaDePagamento folhasPagamentos);

	public List<FolhaDePagamento> ListarFolhaPagamentoMesAno(FolhaDePagamento folhasPagamentos);

	public FolhaDePagamento ValidarFolhaPagamentoMesAno(FolhaDePagamento folhasPagamentos);

	public boolean ValidacaoSimplesMes(int mes);

	public boolean ValidacaoSimplesAno(int ano);

	public List<FolhaDePagamento> RetornarLista();

}
