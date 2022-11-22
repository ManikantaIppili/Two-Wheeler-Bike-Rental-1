package com.bikerent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bikerent.dao.PaymentRepository;
import com.bikerent.entity.Payment;

@SpringBootTest
class TwoWheelerBikeRental1ApplicationTests {

	@Autowired
	PaymentRepository prepo;

	@Test
	@Order(1)
	public void testCreate() {
		Payment p = new Payment();
		p.setId(42);
		p.setCardno("3045-8987-5464");
		p.setNameoncard("karthik");
		p.setAmount(60000);
		p.setCvv(879);
		p.setPaymentmethod("debitcard");
		p.setExmonth(7);
		p.setExyear(2026);

		prepo.save(p);
		assertNotNull(prepo.findById(5).get());

	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Payment> list = prepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getSinglepayment() {
		Payment payment = prepo.findById(2).get();
		assertEquals(45000, payment.getAmount());

	}

}
