alter table SIGNERS_SIGNER alter column MIDLLENAME rename to MIDLLENAME__U38171 ^
alter table SIGNERS_SIGNER alter column MIDLLENAME__U38171 set null ;
alter table SIGNERS_SIGNER add column MIDDLENAME varchar(255) ^
update SIGNERS_SIGNER set MIDDLENAME = '' where MIDDLENAME is null ;
alter table SIGNERS_SIGNER alter column MIDDLENAME set not null ;
