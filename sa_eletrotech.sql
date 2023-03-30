-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 02-Fev-2023 às 12:27
-- Versão do servidor: 8.0.32
-- versão do PHP: 7.4.3-4ubuntu2.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sa_eletrotech`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adm`
--

CREATE TABLE `adm` (
  `idAdm` int NOT NULL,
  `usuario` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `senha` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci COMMENT='Tabela para guardar login do sistema desktop';

--
-- Extraindo dados da tabela `adm`
--

INSERT INTO `adm` (`idAdm`, `usuario`, `senha`) VALUES
(1, 'EletroTech Solutions', '8dac593df37567c3c7396d5a2eac79c9e67f0018d20f672b4e5f83b734b3dee9');

-- --------------------------------------------------------

--
-- Estrutura da tabela `atendimento`
--

CREATE TABLE `atendimento` (
  `idAtendimento` int NOT NULL,
  `idCliente` int NOT NULL,
  `idFuncionario` int NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dataMarcado` timestamp NULL DEFAULT NULL,
  `dataRealizado` timestamp NULL DEFAULT NULL,
  `horario` int DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `avaliacao` int DEFAULT NULL,
  `avaliacaoMensagem` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `atendimento`
--

INSERT INTO `atendimento` (`idAtendimento`, `idCliente`, `idFuncionario`, `tipo`, `endereco`, `dataCriacao`, `dataMarcado`, `dataRealizado`, `horario`, `valor`, `descricao`, `avaliacao`, `avaliacaoMensagem`) VALUES
(1, 2, 2, 'conserto', 'Rua dos bobos, 200', '2023-01-23 00:00:00', '2023-01-24 00:00:00', '2023-01-24 00:00:00', 12, 0, 'Erro na caixa de fusíveis', 5, 'Serviço excelente, técnico foi pontual e muito educado'),
(2, 3, 4, 'avaliacao', 'Rua roxa, 400', '2023-01-02 00:00:00', '2023-01-04 00:00:00', '2023-01-04 00:00:00', 14, 30, 'Houve um curto circuito na tomada da sala', 4, 'Atendimento excelente'),
(3, 2, 2, 'avaliacao', 'Rua dos bobos, 200', '2023-02-01 00:00:00', '2023-02-03 00:00:00', NULL, 13, 0, NULL, NULL, NULL),
(4, 2, 3, 'conserto', 'Rua dos bobos, 200', '2023-02-01 00:00:00', '2023-02-03 00:00:00', NULL, 13, 0, NULL, NULL, NULL),
(5, 3, 2, 'avaliacao', 'Rua roxa, 400', '2023-02-01 00:00:00', '2023-02-04 00:00:00', NULL, 15, 50, NULL, NULL, NULL),
(6, 3, 3, 'conserto', 'Rua roxa, 400', '2023-02-01 00:00:00', '2023-02-04 00:00:00', NULL, 15, 50, NULL, NULL, NULL),
(7, 2, 4, 'conserto', 'Rua roxa, 400', '2023-02-01 00:00:00', '2023-02-04 00:00:00', NULL, 15, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `atendimentosagendados`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `atendimentosagendados` (
`idAtendimento` int
,`nome_Funcionario` varchar(100)
,`nome_Cliente` varchar(100)
,`tipo` varchar(45)
,`endereco` varchar(100)
,`data_Marcada` timestamp
,`hora_Marcada` int
);

-- --------------------------------------------------------

--
-- Estrutura stand-in para vista `avaliacoes`
-- (Veja abaixo para a view atual)
--
CREATE TABLE `avaliacoes` (
`nome` varchar(100)
,`nota` int
,`mensagem` varchar(300)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  `cpf` varchar(18) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  `dataCadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `premium` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `email`, `senha`, `cpf`, `cep`, `endereco`, `contato`, `dataCadastro`, `premium`) VALUES
(2, 'Juzyscreita Rainha', 'yass@email.com', '8dac593df37567c3c7396d5a2eac79c9e67f0018d20f672b4e5f83b734b3dee9', '123.234.345-98', '13.133-091', 'Rua dos bobos, 200', '31 96564-7651', '2023-01-03 00:00:00', 1),
(3, 'Eduarda Alves Pontel', 'eduarda@email.com', 'ad5d54102901659b6e7cda04348233618416a41c584b05658067927c485285cf', '444.333.666-88', '12.987-098', 'Rua roxa, 400', '31 96537-6589', '2022-01-01 00:00:00', 0),
(14, 'aa', 'aa@gmail.com', 'qq', '2', NULL, NULL, '2', '2023-02-02 11:08:26', 0),
(15, 'kj', 'jk@gmail.com', '2', '2', NULL, NULL, '2', '2023-02-02 11:24:55', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(18) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `genero` varchar(5) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `dadosBancarios` varchar(100) DEFAULT NULL,
  `dataContratacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `nome`, `cpf`, `contato`, `idade`, `genero`, `cep`, `endereco`, `salario`, `dadosBancarios`, `dataContratacao`) VALUES
(2, 'Erick Cristiano Gomes Moreira', '148.155.133-60', '31 98321-8923', 18, 'M', '13.882-720', 'Rua verde, 555', 3000, '43569852341-7', '2020-01-02'),
(3, 'Rhian Pereira Oliveira', '444.333.222.-11', '31 98781-5433', 19, 'M', '22.448-310', 'Rua azul, 666', 3000, '139845732098-9', '2019-03-03'),
(4, 'Riquelme Marques Alves Araujo', '111.321.123-70', '31 98700-5585', 19, 'M', '60.553-156', 'Rua amarela, 132', 3000, '553776542908-5', '2019-05-07');

-- --------------------------------------------------------

--
-- Estrutura para vista `atendimentosagendados`
--
DROP TABLE IF EXISTS `atendimentosagendados`;

CREATE VIEW `atendimentosagendados`  AS SELECT `atendimento`.`idAtendimento` AS `idAtendimento`, `funcionario`.`nome` AS `nome_Funcionario`, `cliente`.`nome` AS `nome_Cliente`, `atendimento`.`tipo` AS `tipo`, `atendimento`.`endereco` AS `endereco`, `atendimento`.`dataMarcado` AS `data_Marcada`, `atendimento`.`horario` AS `hora_Marcada` FROM ((`cliente` join `atendimento` on((`cliente`.`idCliente` = `atendimento`.`idCliente`))) join `funcionario` on((`atendimento`.`idFuncionario` = `funcionario`.`idFuncionario`))) WHERE (`atendimento`.`dataRealizado` is null) ORDER BY `atendimento`.`dataMarcado` ASC  ;

-- --------------------------------------------------------

--
-- Estrutura para vista `avaliacoes`
--
DROP TABLE IF EXISTS `avaliacoes`;

CREATE VIEW `avaliacoes`  AS SELECT `cliente`.`nome` AS `nome`, `atendimento`.`avaliacao` AS `nota`, `atendimento`.`avaliacaoMensagem` AS `mensagem` FROM (`cliente` join `atendimento` on((`atendimento`.`idCliente` = `cliente`.`idCliente`))) WHERE (`atendimento`.`avaliacao` is not null)  ;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `atendimento`
--
ALTER TABLE `atendimento`
  ADD PRIMARY KEY (`idAtendimento`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `atendimento`
--
ALTER TABLE `atendimento`
  MODIFY `idAtendimento` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
