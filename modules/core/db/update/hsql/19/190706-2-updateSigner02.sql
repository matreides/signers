update SIGNERS_SIGNER set MIDDLENAME = '' where MIDDLENAME is null ;
alter table SIGNERS_SIGNER alter column MIDDLENAME set not null ;
