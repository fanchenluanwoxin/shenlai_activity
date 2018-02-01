package com.mange.activity;

import com.mange.activity.domain.Table;
import com.mange.activity.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShenlaiActivityApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		List<Integer> nList = new ArrayList<>(list.parallelStream().filter(a -> a.intValue() > 5).collect(Collectors.toList()));
		log.info("list="+list.toString());
		log.info("nList="+nList.toString());
		//lambda表达式对值封闭，对变量开放
		Table table = Table.builder().id(1L).build();
		list.forEach(i -> {
			nList.add(table.getId().intValue()+i);
		});
		List<Integer> aList = list.stream().map(a -> a+=2).collect(Collectors.toList());
		log.info("aList="+aList.toString());
		System.out.println(Integer.valueOf("0").equals(1));
	}
}
