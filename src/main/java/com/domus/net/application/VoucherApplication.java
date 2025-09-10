package com.domus.net.application;

import com.domus.net.application.anotation.Application;
import com.domus.net.domain.dto.VoucherDto;
import com.domus.net.domain.service.FileStorageService;
import com.domus.net.domain.service.VoucherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Application
public class VoucherApplication {

	@Value("${cloudinary.folder.voucher.name}")
	private String folder;
	private final VoucherService voucherService;
	private final FileStorageService fileStorageService;

	public VoucherApplication(VoucherService voucherService, FileStorageService fileStorageService) {
		this.voucherService = voucherService;
		this.fileStorageService = fileStorageService;
	}

	public VoucherDto findById(Long id){
		return voucherService.findById(id);
	}

	public boolean exist(Long id){
		return voucherService.exist(id);
	}

	public boolean existNumReference(String numRef){
		return voucherService.existNumReference(numRef);
	}

	public Page<VoucherDto> getAll(Pageable pageable){
		return voucherService.getAll(pageable);
	}

	public VoucherDto save(VoucherDto voucherDto) throws Exception {

		if (voucherDto.getId()!=null && voucherDto.getId() > 0) {
			var voucherFounded = findById(voucherDto.getId());
			fileStorageService.deleteFile(voucherFounded.getPhoto(), folder);
		}

		String urlSource = fileStorageService.uploadFile(voucherDto.getResourceFile(),folder);
		voucherDto.setPhoto(urlSource);
		return voucherService.save(voucherDto);
	}

	public void delete(Long id){
		voucherService.delete(id);
	}

	public String revertAccountsReceivable(Integer voucherId) {
		return voucherService.revertAccountsReceivable(voucherId);
	}
}
