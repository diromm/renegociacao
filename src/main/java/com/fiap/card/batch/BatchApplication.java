package com.fiap.card.batch;

import javax.sql.DataSource;

import com.fiap.card.batch.model.CadastroProceso;
import com.fiap.card.batch.skipping.CustomSkipPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {
    Logger logger = LoggerFactory.getLogger(BatchApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    /**
     * Metodo de configuracao da leitura do arquivo flat configurado
     * 
     * @param Objeto Resource correspondente ao arquivo Flat a ser lido
     * @return Um FlatFileItemReader pra ser tratado pelo Job
     */

    @Bean
    public FlatFileItemReader<CadastroProceso> fileReader(@Value("${input.file}") String filePath) {
        logger.info("Criando o FlatFileItemReader...");
        FileSystemResource resource = new FileSystemResource(filePath);
        if (resource.exists())
            return new FlatFileItemReaderBuilder<CadastroProceso>()
                    .name("Leitura de Arquivo - Relatorio do dia") // Nome do FlatFileItemReader
                    .resource(resource) // Resource de origem
                    .targetType(CadastroProceso.class) // Classe de destino dos dados do arquivo
                    .addComment("Cod") // Linhas para serem ignoradas no arquivo
                    .delimited()
                    .delimiter("||")
                    .names("codigoCausa", "dataInicioCausa", "cpfConPartePrincipal",
                            "nomeConPartePrincipal",
                            "numeroProcesso",
                            "assunto",
                            "esfera",
                            "nomeProPartePrincipal",
                            "carteira",
                            "unidadeFederacao",
                            "dataFimProcesso",
                            "motivoStatus",
                            "produto",
                            "indenizavel",
                            "recurso",
                            "dataCadastroCausa") // Nomes das colunas do arquivo
                    .build();
        else {
            logger.error("Arquivo de entrada nao foi encontrado no caminho especificado: " + filePath);
        }
        return null;

    }

    /**
     * Item que processara linha a linha do arquivo de entrada
     * @return O item Processor com cada ocorrencia de ClientePotencial ajustada a regra
     */

    @Bean
    public ItemProcessor<CadastroProceso, CadastroProceso> itemProcessor(){
        logger.info("Criando o ItemProcessor...");
        return (CadastroProceso) -> {
//            logger.info(clientePotencial.getNome() + " processado.");
            CadastroProceso.setCodigoCausa(CadastroProceso.getCodigoCausa().trim());
            CadastroProceso.setDataInicioCausa(CadastroProceso.getDataInicioCausa().trim());
            CadastroProceso.setCpfConPartePrincipal(CadastroProceso.getCpfConPartePrincipal().trim());
            CadastroProceso.setNomeConPartePrincipal(CadastroProceso.getNomeConPartePrincipal().trim());
            CadastroProceso.setNumeroProcesso(CadastroProceso.getNumeroProcesso().trim());
            CadastroProceso.setAssunto(CadastroProceso.getAssunto().trim());
            CadastroProceso.setEsfera(CadastroProceso.getEsfera().trim());
            CadastroProceso.setNomeProPartePrincipal(CadastroProceso.getNomeProPartePrincipal().trim());
            CadastroProceso.setCarteira(CadastroProceso.getCarteira().trim());
            CadastroProceso.setUnidadeFederacao(CadastroProceso.getUnidadeFederacao().trim());
            if (CadastroProceso.getDataFimProcesso().equals("[NAO INFORMADO]")) {
                CadastroProceso.setDataFimProcesso("01.01.0001");
            } else {
                CadastroProceso.setDataFimProcesso(CadastroProceso.getDataFimProcesso().trim()); 

            };
            CadastroProceso.setMotivoStatus(CadastroProceso.getMotivoStatus().trim());
            CadastroProceso.setProduto(CadastroProceso.getProduto().trim());
            CadastroProceso.setIndenizavel(CadastroProceso.getIndenizavel().trim());
            CadastroProceso.setRecurso(CadastroProceso.getRecurso().trim());
            CadastroProceso.setDataCadastroCausa(CadastroProceso.getDataCadastroCausa().trim());

            return CadastroProceso;
        };
    }

    /**
     * Método responsavel por gravar linha a linha do arquivo lida no banco de
     * dados.
     * Aqui a estrategia e enviar um INSERT diretamente no SGBD via JDBC para fins
     * de performance
     * 
     * @param datasource O datasource de conexao com o banco de dados
     * @return Um JdbcBatchItemWriter responsavel por gravar
     */
    @Bean
    public JdbcBatchItemWriter<CadastroProceso> databaseWriter(DataSource datasource) {
        logger.info("Criando o ItemWriter...");
        return new JdbcBatchItemWriterBuilder<CadastroProceso>()
                .dataSource(datasource)
                .sql("INSERT INTO cadastro_processos \n" +
                        "(cod_causa, dt_ini_causa, cpf_con_parte_principal, nome_con_parte_principal, nr_processo, assunto, esfera, nome_pro_parte_princial, carteira, uf, dt_fim_processo, motivo_status, produto, indenizavel, recurso, data_cad_causa) \n"
                        +
                        "VALUES(:codigoCausa, :dataInicioCausa, :cpfConPartePrincipal,  \n" +
                        ":nomeConPartePrincipal,\n" +
                        ":numeroProcesso,\n" +
                        ":assunto, \n" +
                        ":esfera, \n" +
                        ":nomeProPartePrincipal,\n" +
                        ":carteira,\n" +
                        ":unidadeFederacao,\n" +
                        ":dataFimProcesso,\n" +
                        ":motivoStatus,\n" +
                        ":produto,\n" +
                        ":indenizavel, \n" +
                        ":recurso, \n" +
                        ":dataCadastroCausa);")
                .beanMapped()
                .build();
    }

    /**
     * Step responsavel por processar efetivamente o arquivo de entrada de clientes
     * potenciais
     * 
     * @param stepBuilderFactory StepBuilderFactory injetado pelo Spring
     * @param itemReader         ItemReader injetado pelo Spring
     * @param itemProcessor      ItemProcessor injetado pelo Spring
     * @param itemWriter         ItemWriter injetado pelo Spring
     * @return Um Step a ser processado pelo Job
     */
    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
            ItemReader<CadastroProceso> itemReader,
            ItemProcessor<CadastroProceso, CadastroProceso> itemProcessor,
            ItemWriter<CadastroProceso> itemWriter) {
        logger.info("Recuperando STEP: Step Chunk - Processamento do arquivo de Clientes Potenciais");
        return stepBuilderFactory.get("Step Chunk - Processamento do arquivo de Clientes Potenciais")
                .<CadastroProceso, CadastroProceso>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .faultTolerant()
                .skipPolicy(new CustomSkipPolicy())
                .allowStartIfComplete(true)
                .build();
    }

    /**
     * Job a ser invocado pelo Spring Batch para processar o arquivo de entrada de
     * clientes potenciais
     * 
     * @param jobBuilderFactory                            Um JobBuilderFactory
     *                                                     injetado pelo Spring
     *                                                     Batch
     * @param stepProcessamentoArquivoDeClientesPotenciais O Step injetado pelo
     *                                                     Spring Batch
     * @return Um objeto Job a ser iniciado pelo Spring Batch
     */
    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
            Step stepProcessamentoArquivoDeClientesPotenciais) {
        return jobBuilderFactory.get("Job - Processar arquivo de Clientes Potenciais")
                .start(stepProcessamentoArquivoDeClientesPotenciais)
                .build();
    }
}
