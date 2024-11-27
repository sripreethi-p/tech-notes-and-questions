package com.dsa.algorithms.utils;


import com.dsa.algorithms.domain.java.Animal;
import com.dsa.algorithms.domain.java.AnimalDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoMapper {

    PojoMapper MAPPER = Mappers.getMapper(PojoMapper.class);

    @Mapping(source = "name", target = "name", qualifiedByName = "entityNameToDtoName")
    AnimalDto toDto(Animal animal);

    @Mapping(target = "age", ignore = true)
    @Mapping(source = "name", target = "name", qualifiedByName = "dtoNameToEntityName")
    Animal toEntity(AnimalDto animalDto);


    @Named("entityNameToDtoName")
    default String entityNameToDtoName(String entityName) throws JsonProcessingException {
        return entityName+"Dto";
    }

    @Named("dtoNameToEntityName")
    default String dtoNameToEntityName(String dtoName) throws JsonProcessingException {
        return dtoName+"Entity";
    }
}
