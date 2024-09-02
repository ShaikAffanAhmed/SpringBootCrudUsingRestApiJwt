package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.BudgetDetails;
import com.app.entity.Notification;
import com.app.repository.BudgetDetailsRepository;
import com.app.repository.NotificationRepository;


@Service
public class BudgetDetailsService {

	@Autowired
	private BudgetDetailsRepository detailsRepository;
	@Autowired
	private NotificationRepository notificationRepository;

	// create
	public BudgetDetails save(BudgetDetails budgetDetails) {
		return detailsRepository.save(budgetDetails);
	}

	// fetch
	public List<BudgetDetails> findAll() {
		return detailsRepository.findAll();
	}

	// update
	public BudgetDetails update(Integer id, BudgetDetails budgetDetails) {
		if (detailsRepository.existsById(id)) {
			budgetDetails.setBudgetId(id);
			return detailsRepository.save(budgetDetails);
		} else {
			throw new RuntimeException("BudgetDetails not found with id" + id);
		}
	}

	//delete
	public String deleteById(Integer id) {
	    Optional<BudgetDetails> details = this.detailsRepository.findById(id);
	    
	    if (details.isEmpty()) {
	        return "This ID doesn't exist";
	    }
	    
	    this.detailsRepository.deleteById(id);
	    return "Deleted successfully";
	}


	//save with notification table
	public String saveWithNotification() {
		List<Notification> allNotificationDetails = notificationRepository.findAll();

		for (int i = 0; i < allNotificationDetails.size(); i++) {

			try {
				BudgetDetails budgetDetails = new BudgetDetails();
				budgetDetails.setCompanyId(allNotificationDetails.get(i).getCompanyId());
				budgetDetails.setPropertyGroupId(allNotificationDetails.get(i).getPropertyGroupId());
				budgetDetails.setAmount(10.0);
				budgetDetails.setServiceCode("SCW-01");
				budgetDetails.setTotalBudget(10.00);
				budgetDetails.setVat(10.00);

				if (i == 2) {
					System.out.println("skipped id is: "+allNotificationDetails.get(i).getCompanyId());
					String largeServiceCode = "a".repeat(10000);
		            budgetDetails.setServiceCode(largeServiceCode);
				}
				detailsRepository.save(budgetDetails);
			} catch (Exception e) {
				
				System.out.println("Error saving budget details: " + e.getMessage());
			}
		}
		return "Success";
	}

}
