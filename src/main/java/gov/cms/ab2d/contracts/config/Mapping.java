//package gov.cms.ab2d.contracts.config;
//
//import gov.cms.ab2d.contracts.model.ContractDTO;
//import gov.cms.ab2d.contracts.service.ContractService;
//import javax.annotation.PostConstruct;
//import org.modelmapper.AbstractConverter;
//import org.modelmapper.Converter;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Mapping {
//
////    private final ContractService contractService;
//
//    private final RoleService roleService;
//
//    private ModelMapper modelMapper;
//
//    public Mapping(ContractService contractService, RoleService roleService) {
//        this.contractService = contractService;
//        this.roleService = roleService;
//    }
//
//    @PostConstruct
//    public void init() {
//        modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setSkipNullEnabled(true);
//
//        Converter<String, Role> roleDTOToRoleConverter = context -> {
//            if (context.getSource() == null) {
//                return null;
//            } else {
//                return roleService.findRoleByName(context.getSource());
//            }
//        };
//        Converter<Set<Role>, String> roleToRoleDTOConverter = context -> {
//            if (context.getSource() == null || context.getSource().isEmpty()) {
//                return null;
//            } else {
//                return context.getSource().iterator().next().getName();
//            }
//        };
//
//        Converter<ContractDTO, Contract> sponsorDTOSponsorConverter = new AbstractConverter<>() {
//            protected Contract convert(ContractDTO source) {
//                //noinspection OptionalGetWithoutIsPresent
//                if (source != null) {
//                    return contractService.getContractByContractNumber(source.getContractNumber()).get(); //NOSONAR
//                }
//                return null;
//            }
//        };
//
//        Converter<ContractDTO, Long> contractDTOtoContractIDConverter = pdpContractDTO -> {
//            Optional<Contract> optionalContract = contractService.getContractByContractNumber(pdpContractDTO.getSource().getContractNumber());
//            return optionalContract.map(Contract::getId).orElse(null);
//        };
//
//        Converter<Long, ContractDTO> contractIDtoContractDTOConverter = mappingContext -> {
//            if (mappingContext.getSource() != null) {
//                return contractService.getContractByContractId(mappingContext.getSource()).toDTO();
//            }
//            return null;
//        };
//
//        modelMapper.addConverter(sponsorDTOSponsorConverter);
//        modelMapper.createTypeMap(PdpClient.class, PdpClientDTO.class)
//                .addMappings(mapper -> mapper.using(roleToRoleDTOConverter).map(PdpClient::getRoles, PdpClientDTO::setRole))
//                .addMappings(mapper -> mapper.using(contractIDtoContractDTOConverter).map(PdpClient::getContractId, PdpClientDTO::setContract));
//        modelMapper.createTypeMap(PdpClientDTO.class, PdpClient.class)
//                .addMappings(mapper -> mapper.using(roleDTOToRoleConverter).map(PdpClientDTO::getRole, PdpClient::addRole))
//                .addMappings(mapper -> mapper.using(contractDTOtoContractIDConverter).map(PdpClientDTO::getContract, PdpClient::setContractId));
//    }
//
//    public ModelMapper getModelMapper() {
//        return modelMapper;
//    }
//}
