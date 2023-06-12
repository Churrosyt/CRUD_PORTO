create table movimentacao(

        id bigint not null auto_increment,
        movimentacoes varchar(20) not null,
        datahorainicio TIMESTAMP,
        datahorafim TIMESTAMP,

        primary key(id)
);