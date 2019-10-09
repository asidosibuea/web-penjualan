package com.mvc.controller;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.dto.MstBarangAllDto;
import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstCustomerAllDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.TrDetailPenjualanDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.service.MstBarangSvc;
import com.mvc.service.MstCustomerSvc;
import com.mvc.service.MstKaryawanSvc;
import com.mvc.service.TrDetailPenjualanSvc;
import com.mvc.service.TrHeaderPenjualanSvc;



@Controller
@RequestMapping("/header-penjualan")
public class TrHeaderPenjualanController {
	
	
	private List<TrDetailPenjualanDto> listDetails = new LinkedList<TrDetailPenjualanDto>();
	private List<TrDetailPenjualanDto> listDetailsEditForm = new LinkedList<TrDetailPenjualanDto>();
	private List<TrDetailPenjualanDto> listBuatPost = new LinkedList<TrDetailPenjualanDto>();
	
	@Autowired
	private TrHeaderPenjualanSvc service;
	
	@Autowired
	private MstCustomerSvc customerService;
	
	@Autowired
	private MstKaryawanSvc employeeService;
	
	@Autowired
	private MstBarangSvc barangSvc;
	
	@Autowired 
	private TrDetailPenjualanSvc detailSvc;
	
	@RequestMapping("/all")
	public String showAllWithPagination(@RequestParam(value="cari", defaultValue="", required=false) String cari, 
			@RequestParam(value="page", defaultValue="1", required=false) int page, Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("headerData");
		session.invalidate();
		Map<String, Object> map = service.searchPenjualan(cari, page);
		List<TrHeaderPenjualanDto> listDto =  (List<TrHeaderPenjualanDto>) map.get("list");
		int jumlahHalaman = (int) map.get("jumlahHalaman");
		model.addAttribute("list", listDto);
		model.addAttribute("jumlahHalaman", jumlahHalaman);
		return "listheaderpenjualan";
	}
	
	@RequestMapping("/add")
	public String getHeaderInsertPage(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		List<MstCustomerAllDto> customersDto = customerService.findAllCustomer();
		List<MstKaryawanDto> employeesDto = employeeService.findAllKaryawan();
		Map<String, String> customerList = new HashMap<String, String>();
		Map<String, String> employeesList = new HashMap<String, String>();
		for(MstCustomerAllDto dto : customersDto){
			customerList.put(dto.getKodeCustomer(), dto.getNamaCustomer());
		}
		for(MstKaryawanDto dto : employeesDto){
			employeesList.put(dto.getKodeKaryawan(), dto.getNamaKaryawan());
		}
		TrHeaderPenjualanDto headerDto;
		
		int totalTanpaDiskon = 0;
		if (session.getAttribute("headerData") == null) {
            headerDto = new TrHeaderPenjualanDto();
            listDetails.clear();
        } else {
            headerDto = (TrHeaderPenjualanDto) session.getAttribute("headerData");	

            for(TrDetailPenjualanDto details : listDetails){
            	totalTanpaDiskon +=details.getSubtotal();
            }
            headerDto.setHargaTotal(totalTanpaDiskon);
            
        }
		
		model.addAttribute("headerPenjualan", headerDto);
		model.addAttribute("customers", customerList);
		model.addAttribute("employees", employeesList);
		model.addAttribute("listDetilDto", listDetails);
		model.addAttribute("totalTanpaDiskon", totalTanpaDiskon);
		return "addheaderpenjualan";
	}
	

	@RequestMapping("/add-with-session")
	public String getAddWithSession(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		TrHeaderPenjualanDto headerDto = (TrHeaderPenjualanDto) session.getAttribute("headerData");
		model.addAttribute("headerPenjualan", headerDto);
		
		return "addheaderpenjualan";
	}
	
	@RequestMapping("/save") //fake submit --> cuma save ke session
	public String saveHeader(@ModelAttribute("headerPenjualan") TrHeaderPenjualanDto dto,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("headerData", dto);
		
		return "redirect:/header-penjualan/add-detail";
	}
	
	@RequestMapping("/add-detail")
	public String addDetail(
			HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		List<MstBarangAllDto> barangsDto = barangSvc.findAllBarang();
		Map<String, String> productsName = new HashMap<>();
		for(MstBarangAllDto barang : barangsDto){
			productsName.put(barang.getKodeBarang(), barang.getNamaBarang());
		}
		model.addAttribute("detailPenjualan", new TrDetailPenjualanDto());
		model.addAttribute("products", productsName);
		
		return "adddetailpenjualan";
	}
	
	
	@RequestMapping("/save-detail")
	public String saveDetail(@ModelAttribute("detailPenjualan") TrDetailPenjualanDto detilDto, HttpServletRequest request, Model model){		
		HttpSession session = request.getSession();
		listDetails.add(detilDto);
		MstBarangDto dto = barangSvc.findOneBarang(detilDto.getKodeBarang());
		detilDto.setNamaBarang(dto.getNamaBarang());
		
		return "redirect:/header-penjualan/add";
	}
	
	@RequestMapping("/final-post") // untuk final save ke database
	public String saveFinalHeader(@ModelAttribute("headerPenjualan") TrHeaderPenjualanDto dto,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		
		service.save(dto);
		for(TrDetailPenjualanDto detail : listDetails){
			detail.setNoNota(dto.getNoNota());
			detailSvc.save(detail);
		}
		
		return "redirect:/header-penjualan/all";
	}
	
	@RequestMapping("/delete/{noNota}")
	public String hapus(@PathVariable String noNota,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		
		
		service.delete(noNota);
		detailSvc.deleteDetail(noNota);
		return "redirect:/header-penjualan/all";
	}
	
	@RequestMapping("/edit/{noNota}")
	public String editPenjualan(@PathVariable String noNota, Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		
		TrHeaderPenjualanDto headerDto = service.findPenjualanByNoNota(noNota);
		List<TrDetailPenjualanDto> detailsDto = detailSvc.findAllDetailPenjualan(noNota);
		
		List<MstCustomerAllDto> customersDto = customerService.findAllCustomer();
		List<MstKaryawanDto> employeesDto = employeeService.findAllKaryawan();
		Map<String, String> customerList = new HashMap<String, String>();
		Map<String, String> employeesList = new HashMap<String, String>();
		for(MstCustomerAllDto dto : customersDto){
			customerList.put(dto.getKodeCustomer(), dto.getNamaCustomer());
		}
		for(MstKaryawanDto dto : employeesDto){
			employeesList.put(dto.getKodeKaryawan(), dto.getNamaKaryawan());
		}
		
		int totalTanpaDiskon = 0;
		if (session.getAttribute("headerEditData") == null) {
            //headerDto = new TrHeaderPenjualanDto();
            listDetailsEditForm.clear();
            listBuatPost.clear();
       } else {
            	
    	   detailsDto.addAll(listDetailsEditForm);
            for(TrDetailPenjualanDto details : detailsDto){
            	totalTanpaDiskon +=details.getSubtotal();
            }
            headerDto.setHargaTotal(totalTanpaDiskon);
            listBuatPost.addAll(detailsDto);
            
        }

		model.addAttribute("headerPenjualan", headerDto);
		model.addAttribute("customers", customerList);
		model.addAttribute("employees", employeesList);
		model.addAttribute("listDetilDto", detailsDto);
		model.addAttribute("totalTanpaDiskon", totalTanpaDiskon);
		
		return "editheaderpenjualan";
	}
	
	@RequestMapping("/edit-header/save-session") //fake submit --> cuma save ke session
	public String saveEditHeader(@ModelAttribute("headerPenjualan") TrHeaderPenjualanDto dto,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("headerEditData", dto);
		
		return "redirect:/header-penjualan/edit-header/add-detail";
	}
	

	@RequestMapping("/edit-header/add-detail")
	public String addDetailFromEditHeader(
			HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		List<MstBarangAllDto> barangsDto = barangSvc.findAllBarang();
		Map<String, String> productsName = new HashMap<>();
		for(MstBarangAllDto barang : barangsDto){
			productsName.put(barang.getKodeBarang(), barang.getNamaBarang());
		}
		model.addAttribute("detailPenjualan", new TrDetailPenjualanDto());
		model.addAttribute("products", productsName);
		
		return "editheader-adddetailpenjualan";
	}
	
	
	@RequestMapping("/edit-header/save-detail")
	public String saveDetailFromEditHeader(@ModelAttribute("detailPenjualan") TrDetailPenjualanDto detilDto, HttpServletRequest request, Model model){		
		HttpSession session = request.getSession();
		TrHeaderPenjualanDto headerDto = (TrHeaderPenjualanDto) session.getAttribute("headerEditData");
		
		listDetailsEditForm.add(detilDto);
		MstBarangDto dto = barangSvc.findOneBarang(detilDto.getKodeBarang());
		detilDto.setNamaBarang(dto.getNamaBarang());
		
		return "redirect:/header-penjualan/edit/"+headerDto.getNoNota();
	}
	
	@RequestMapping("/edit-header/final-post") // untuk final save ke database
	public String saveEditHeaderFinal(@ModelAttribute("headerPenjualan") TrHeaderPenjualanDto dto,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		
		service.save(dto);
		for(TrDetailPenjualanDto detail : listBuatPost){
			detail.setNoNota(dto.getNoNota());
			detailSvc.save(detail);
		}
		
		return "redirect:/header-penjualan/all";
	}
	
	@RequestMapping("/edit-header/delete-detail/{noNota}/{kodeDetail}")
	public String hapusDetail(@PathVariable(value="noNota") String noNota, @PathVariable(value="kodeDetail") String kodeDetail,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		detailSvc.delete(kodeDetail);
		return "redirect:/header-penjualan/edit/"+noNota;
	}
}
