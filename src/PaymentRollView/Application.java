package PaymentRollView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import PaymentRollController.CalculoFolha;
import PaymentRollController.ValidaCPF;
import PaymentRollDAO.FolhaDePagamentoDAO;
import PaymentRollDAO.FuncionarioDAO;
import PaymentRollModel.FolhaDePagamento;
import PaymentRollModel.Funcionario;

public class Application 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		File filePaymentRoll = new File("C:\\Users\\be385990\\Documents\\eclipse\\paymentroll.txt");
		File fileEmployee = new File("C:\\Users\\be385990\\Documents\\eclipse\\employee.txt");
		
		
		Funcionario funcionario = new Funcionario(); 
		Funcionario funcionarioAux = new Funcionario();
        FolhaDePagamento folhaPagamento = new FolhaDePagamento();
        CalculoFolha calculoFolha = new CalculoFolha();
        ValidaCPF validaCpf = new ValidaCPF();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        FolhaDePagamentoDAO folhaPagamentoDao = new FolhaDePagamentoDAO();
        String opcao;
        float salarioBruto, valorInss, valorFgts, salarioLiquido, impostoRenda, 
        totalSalarioLiquido = 0, totalSalarioBruto = 0;
        
        do
        {
            System.out.println("         -- System of Payment Roll -- ");
            System.out.println("\n            1 - Register Employee");
            System.out.println("            2 - Register Payment Roll");
            System.out.println("            3 - Research Payment Roll");
            System.out.println("            4 - List Payment Roll");
            System.out.println("            5 - List All Employees");
            System.out.println("            6 - List All Registered Payments Roll");
            System.out.println("            7 - Read File 'filePaymentRoll.txt'");
            System.out.println("            8 - Read File 'fileEmployee.txt'");
            System.out.println("            0 - EXIT");
            
            opcao = input.nextLine();
            
            switch (opcao)
            {
                case "1":
                    funcionario = new Funcionario();

                    System.out.println("         -- Register Employee --");
                    System.out.println("\n            Employee CPF: ");
                    String numCpf = input.next();
                    numCpf = numCpf.trim();
                    numCpf = numCpf.replace(".", "").replace("-", "");
                    funcionario.numCpf = numCpf;
                    
                    System.out.println("\n" + numCpf);
                    if (validaCpf.ValidarCpf(numCpf) == true)
                    {
                        System.out.println("\n            CPF Valid...");
                        System.out.println("\n            Employee Name: ");
                        String nomeFuncionario = input.next();
                        funcionario.nomeFuncionario = nomeFuncionario;
                        
                        System.out.println("\n" + funcionario.nomeFuncionario);
                        
                        if(funcionarioDao.SalvarFuncionario(funcionario) == true)
                        {
                             System.out.println("\n            Employee Saved successfully!!!\n\n");
                        }
                        else
                        {
                             System.out.println("\n            Employe NOT saved!!!\n\n");
                        }
                    }
                    else
                    {
                        System.out.println("\n            CPF Not Valid!!!\n\n");
                    }
                    break;

                case "2":
                    folhaPagamento = new FolhaDePagamento();
                    funcionario = new Funcionario();

                    System.out.println("         -- Register Payment Roll --");
                    System.out.println("\n            Employee CPF: ");
                    numCpf = input.next();
                    numCpf = numCpf.trim();
                    numCpf = numCpf.replace(".", "").replace("-", "");
                    funcionario.numCpf = numCpf;
                    
                    System.out.println("\n            Employee Name: ");
                	String nomeFuncionario = input.next();
                    funcionario.nomeFuncionario = nomeFuncionario;
                    
                    funcionarioAux = funcionarioDao.BuscarFuncionarioCpf(funcionario);
                    
                    if (funcionarioAux != null )
                    {
                        folhaPagamento.Funcionario = funcionario;

                        System.out.println("            Month: ");
                        folhaPagamento.Mes = input.nextInt();
                        if (folhaPagamentoDao.ValidacaoSimplesMes(folhaPagamento.Mes) == true)
                        {
                            System.out.println("            Year: ");
                            folhaPagamento.Ano = input.nextInt();
                            if (folhaPagamentoDao.ValidacaoSimplesAno(folhaPagamento.Ano) == true)
                            {
                                if (folhaPagamentoDao.BuscarFolhaPagamentoFuncionarioMesAno(funcionario,folhaPagamento) != null)
                                {
                                    System.out.println("            Total of Worked Hours: ");
                                    folhaPagamento.HorasTrabalhadas = input.nextInt();

                                    System.out.println("            Time Value for each Worked Hour: ");
                                    folhaPagamento.ValorHora = (float) input.nextFloat();

                                    folhaPagamentoDao.SalvarFolhaPagamento(folhaPagamento);
                                    System.out.println("\n              Informations of Payment Roll Saved successfully!!!...\n\n");

                                }
                                else
                                {
                                    System.out.println("\n              Payment Roll NOT saved!!!...\n\n");
                                }
                           }
                           else
                           {
                               System.out.println("\n              Invalid Year!!!\n\n");
                           }
                       }
                       else
                       {
                           System.out.println("\n              Invalid Month!!!\n\n");
                       }
                   }
                   else
                   {
                      System.out.println("\n              CPF Not Valid!!!\n\n");
                   }
                  break;

                case "3":
                    funcionario = new Funcionario();
                    folhaPagamento = new FolhaDePagamento();
                    calculoFolha = new CalculoFolha();

                    System.out.println("         --  Research Payment Roll --");
                    System.out.println("\n              Enter the Employee CPF to Research: ");
                    numCpf = input.next();
                    numCpf = numCpf.trim();
                    numCpf = numCpf.replace(".", "").replace("-", "");
                    funcionario.numCpf = numCpf;
                
                    System.out.println("\n            Employee Name: ");
                	nomeFuncionario = input.next();
                    funcionario.nomeFuncionario = nomeFuncionario;
                    
                    funcionarioAux = funcionarioDao.BuscarFuncionarioCpf(funcionario);
                    
                    if (funcionarioAux != null )
                    {
                    	
                        System.out.println("            Month of Payment Roll: ");
                        int Mes = input.nextInt();
                        folhaPagamento.Mes = Mes;
                        
                        System.out.println("            Year of Payment Roll: ");
                        int Ano = input.nextInt();
                        folhaPagamento.Ano = Ano;
                        
                        if (folhaPagamentoDao.BuscarFolhaPagamentoFuncionarioMesAno(funcionario, folhaPagamento) != null)
                        {
                            for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamentoDao.BuscarFolhaPagamentoFuncionarioMesAno(funcionario, folhaPagamento))
                            {
                            	try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePaymentRoll))) 
                            	{
                            		System.out.println("\n            Employee Name: " + folhaPagamentoCadastrada.Funcionario.nomeFuncionario);
                            		bw.write("Employee Name: " + folhaPagamentoCadastrada.Funcionario.nomeFuncionario);
                                    bw.newLine();
                            		System.out.println("            Employee CPF: " + folhaPagamentoCadastrada.Funcionario.numCpf);
                            		bw.write("Employee CPF: " + folhaPagamentoCadastrada.Funcionario.numCpf);
                                    bw.newLine();
                            		System.out.println("            Month / Year : " + folhaPagamentoCadastrada.Mes + "/ " + folhaPagamentoCadastrada.Ano);
                            		bw.write("Month / Year : " + folhaPagamentoCadastrada.Mes + "/" + folhaPagamentoCadastrada.Ano);
                                    bw.newLine();
                            		System.out.println("            Worked Hours: " + folhaPagamentoCadastrada.HorasTrabalhadas);
                            		bw.write("Worked Hours: " + folhaPagamentoCadastrada.HorasTrabalhadas);
                                    bw.newLine();
                            		System.out.println("\t            Time Value: R$" + folhaPagamentoCadastrada.ValorHora);
                            		bw.write("Time Value: R$" + folhaPagamentoCadastrada.ValorHora);
                                    bw.newLine();
                            		salarioBruto = calculoFolha.CalculoFolhaPagamentoSalarioBruto(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                            		System.out.println("\t            Gross Salary: R$" + salarioBruto);
                            		bw.write("Gross Salary: R$" + salarioBruto);
                                    bw.newLine();
                            		impostoRenda = calculoFolha.CalculoFolhaPagamentoIR(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                            		System.out.println("\t            Imposto de Renda: R$" + impostoRenda);
                            		bw.write("Imposto de Renda: R$" + impostoRenda);
                                    bw.newLine();
                            		valorInss = calculoFolha.CalculoFolhaPagamentoInss(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                            		System.out.println("\t            INSS: R$" + valorInss);
                            		bw.write("INSS: R$" + valorInss);
                                    bw.newLine();
                            		valorFgts = calculoFolha.CalculoFolhaPagamentoFgts(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                            		System.out.println("\t            FGTS: R$" + valorFgts);
                            		bw.write("FGTS: R$" + valorFgts);
                            		bw.newLine();
                            		salarioLiquido = calculoFolha.CalculoFolhaPagamentoSalarioLiquido(salarioBruto, valorInss, impostoRenda);
                            		System.out.println("\t            Net Salary: R$" + salarioLiquido + "\n\n");
                            		bw.write("Net Salary: R$" + salarioLiquido);
                            		bw.newLine();
                                  
                                } catch (IOException e) {
                                    System.out.println("\n\nUnable to read file " + filePaymentRoll.toString());
                                }
                            }
                        }
                        else
                        {
                            System.out.println("\n            Month or Year informed NOT Found!\n\n");
                        }
                    }
                    else
                    {
                        System.out.println("\n            CPF Not Valid!!!\n\n");
                    }
                  break;

                case "4":
                    funcionario = new Funcionario();
                    folhaPagamento = new FolhaDePagamento();
                    calculoFolha = new CalculoFolha();

                    System.out.println("            --  List Payment Roll --");
                    System.out.println("\n            Month for research: ");
                    int Mes = input.nextInt();
                    folhaPagamento.Mes = Mes;
                    System.out.println("            Year for research: ");
                    int Ano = input.nextInt();
                    folhaPagamento.Ano = Ano;

                    totalSalarioLiquido = 0;
                    totalSalarioBruto = 0;
                    
                    for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamentoDao.ListarFolhaPagamentoMesAno(folhaPagamento))
                    {
                        System.out.println("\n            Employee Name: " + folhaPagamentoCadastrada.Funcionario.nomeFuncionario);
                        System.out.println("            Employee CPF: " + folhaPagamentoCadastrada.Funcionario.numCpf);
                        System.out.println("            Month / Year : " + folhaPagamentoCadastrada.Mes + "/ " + folhaPagamentoCadastrada.Ano);
                        System.out.println("            Worked Hours: " + folhaPagamentoCadastrada.HorasTrabalhadas);
                        System.out.println("\t            Valor da Hora: R$" + folhaPagamentoCadastrada.ValorHora);
                        salarioBruto = calculoFolha.CalculoFolhaPagamentoSalarioBruto(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                        System.out.println("\t            Gross Salary: R$" + salarioBruto);
                        impostoRenda = calculoFolha.CalculoFolhaPagamentoIR(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                        System.out.println("\t            Imposto de Renda: R$" + impostoRenda);
                        valorInss = calculoFolha.CalculoFolhaPagamentoInss(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                        System.out.println("\t            INSS: R$" + valorInss);
                        valorFgts = calculoFolha.CalculoFolhaPagamentoFgts(folhaPagamentoCadastrada.HorasTrabalhadas, (float) folhaPagamentoCadastrada.ValorHora);
                        System.out.println("\t            FGTS: R$" + valorFgts);
                        salarioLiquido = calculoFolha.CalculoFolhaPagamentoSalarioLiquido(salarioBruto, valorInss, impostoRenda);
                        System.out.println("\t            Net Salary: R$" + salarioLiquido + "\n\n");

                        totalSalarioLiquido += salarioLiquido;
                        totalSalarioBruto += salarioBruto;
                    }
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePaymentRoll))) 
                	{
                    	System.out.println("\n\t            Total of Gross Salary: R$" + totalSalarioBruto);
                    	bw.write("Total of Gross Salary: R$" + totalSalarioBruto);
                    	bw.newLine();
                    	System.out.println("\t            Total of Net Salary: R$" + totalSalarioLiquido + "\n\n");
                    	bw.write("Total of Net Salary: R$" + totalSalarioLiquido);
                    	bw.newLine();
                	}
                    catch (IOException e)
                    {
                    	System.out.println("Unable to read file \n\n" + filePaymentRoll.toString());
                    }

                    break;

                case "5":
                    funcionario = new Funcionario();

                    System.out.println("         --  List All Employees --");
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileEmployee)))
                    {
                    	for (Funcionario funcionarioCadastrado : funcionarioDao.RetornarLista())
                    	{
                    		if(funcionarioCadastrado != null)
                    		{
                    		 
                    			bw.newLine();
                    			System.out.println("\n            Employee Name: " + funcionarioCadastrado.nomeFuncionario);
                    			bw.write("Employee Name: " + funcionarioCadastrado.nomeFuncionario);
                    			bw.newLine();
                    			System.out.println("            Employee CPF: " + funcionarioCadastrado.numCpf + "\n\n");
                    			bw.write("Employee CPF: " + funcionarioCadastrado.numCpf);
                    			bw.newLine();
                    		}
                    	}
                    }
                    catch (IOException e)
                    {
                    	System.out.println("Unable to read file \n\n" + fileEmployee.toString());
                    }

                    break;

                case "6":
                    folhaPagamento = new FolhaDePagamento();
                    funcionario = new Funcionario();

                    System.out.println("         --  List All Registered Payments Roll --");
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePaymentRoll)))
                    {
                    	for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamentoDao.RetornarLista())
                    	{
                    		if(folhaPagamentoCadastrada != null)
                    		{
                    				bw.newLine();
                    				System.out.println("\n            Employee Name: " + folhaPagamentoCadastrada.Funcionario.nomeFuncionario);
                    				bw.write("Employee Name: " + folhaPagamentoCadastrada.Funcionario.nomeFuncionario);
                    				bw.newLine();
                    				System.out.println("            Employee CPF: " + folhaPagamentoCadastrada.Funcionario.numCpf);
                    				bw.write("Employee CPF: " + folhaPagamentoCadastrada.Funcionario.numCpf);
                    				bw.newLine();
                    				System.out.println("            Month: " + folhaPagamentoCadastrada.Mes);
                    				bw.write("Month: " + folhaPagamentoCadastrada.Mes);
                    				bw.newLine();
                    				System.out.println("            Year: " + folhaPagamentoCadastrada.Ano);
                    				bw.write("Year: " + folhaPagamentoCadastrada.Ano);
                    				bw.newLine();
                    				System.out.println("            Worked Hours: " + folhaPagamentoCadastrada.HorasTrabalhadas);
                    				bw.write("Worked Hours: " + folhaPagamentoCadastrada.HorasTrabalhadas);
                    				bw.newLine();
                    				System.out.printf("            Time Value: R$" + folhaPagamentoCadastrada.ValorHora + "\n\n");
                    				bw.write("Time Value: R$" + folhaPagamentoCadastrada.ValorHora);
                    				bw.newLine();
                    		}
                    	}
                    }
                    catch (IOException e)
                    {
                    	System.out.println("Unable to read file \n\n" + filePaymentRoll.toString());
                    }

                    break;
                    
                case "7":
                    BufferedReader br = null;
                    
                    try {
                        FileReader fr = new FileReader(filePaymentRoll);
                        br = new BufferedReader(fr);
                        
                        String line;
                        
                        for (FolhaDePagamento folhaPagamentoCadastrada : folhaPagamentoDao.RetornarLista())
                        {
                        	if(folhaPagamentoCadastrada != null)
                        	{
                        		while( (line = br.readLine()) != null ) 
                        		{
                        			System.out.println(line);
                        		}
                        	}
                        }
                        
                     }
                    catch (FileNotFoundException e) 
                    {
                        System.out.println("\n\nFile not found: " + filePaymentRoll.toString());
                    } 
                    
                    catch (IOException e) 
                    {
                        System.out.println("\n\nUnable to read file: " + filePaymentRoll.toString());
                    }
                    finally {
                        try {
                            br.close();
                        }
                        catch (IOException e) 
                        {
                            System.out.println("\n\nUnable to close file: " + filePaymentRoll.toString());
                        }
                        catch(NullPointerException ex) 
                        {
                            // arquivo nunca abriu provavelmente
                        }
                    }
                    
                    break;
                    
                case "8":
                	 br = null;
                    
                    try {
                        FileReader fr = new FileReader(fileEmployee);
                        br = new BufferedReader(fr);
                        
                        String line;
                        
                        for (Funcionario funcionarioCadastrado : funcionarioDao.RetornarLista())
                        {
                        	if(funcionarioCadastrado != null)
                        	{
                        		while( (line = br.readLine()) != null ) 
                        		{
                        			System.out.println(line);
                        		}
                        	}
                        }
                        
                        while( (line = br.readLine()) != null ) 
                        {
                            System.out.println(line);
                        }
                        
                    }
                    catch (FileNotFoundException e) 
                    {
                        System.out.println("\n\nFile not found: " + fileEmployee.toString());
                    } 
                    
                    catch (IOException e) 
                    {
                        System.out.println("\n\nUnable to read file: " + fileEmployee.toString());
                    }
                    finally {
                        try {
                            br.close();
                        }
                        catch (IOException e) 
                        {
                            System.out.println("\n\nUnable to close file: " + fileEmployee.toString());
                        }
                        catch(NullPointerException ex) 
                        {
                            // arquivo nunca abriu provavelmente
                        }
                    }
                    
                    break;

                case "0":
                	
                	System.exit(0);
                	
                    break;
            }
        } while (!opcao.equals("0"));
    }
}