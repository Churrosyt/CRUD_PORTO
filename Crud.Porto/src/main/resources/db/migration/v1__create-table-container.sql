create table container(

        id bigint not null auto_increment,
        nome varchar(100) not null,
        numero varchar(20) not null,
        tipo varchar(20) not null,
        status varchar(20) not null,
        categoria varchar(20) not null,

        primary key(id)
);