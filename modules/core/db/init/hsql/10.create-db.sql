-- begin SIGNERS_SIGNER
create table SIGNERS_SIGNER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    SURNAME varchar(255) not null,
    MIDLLENAME varchar(255) not null,
    ORGANIZATION varchar(255) not null,
    DATE_ varchar(255) not null,
    --
    primary key (ID)
)^
-- end SIGNERS_SIGNER
