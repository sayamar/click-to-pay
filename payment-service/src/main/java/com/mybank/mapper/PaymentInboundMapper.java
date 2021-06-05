package com.mybank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mybank.data.entities.InboundPayments;
import com.mybank.intrabank.model.FundTransferDetl;

@Mapper(implementationPackage = "mapper.impl")
public interface PaymentInboundMapper {

	PaymentInboundMapper INSTACE = Mappers.getMapper(PaymentInboundMapper.class);
	
	InboundPayments fundTrasnferDetlToInboundPayments(FundTransferDetl payload);
}
