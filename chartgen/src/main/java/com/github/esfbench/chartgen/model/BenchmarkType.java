package com.github.esfbench.chartgen.model;

import static com.github.esfbench.chartgen.model.Benchmark.BenchmarkGroup.*;
import static java.lang.String.format;

import com.github.esfbench.chartgen.model.Benchmark.BenchmarkGroup;

public enum BenchmarkType {
	BASELINE("baseline", THRESHOLD),
	BASELINE_LEGACY("baseline_legacy", THRESHOLD),
	PLAIN("plain", ITERATION),
	PLAIN_LEGACY("plain_legacy", ITERATION),
	POOLED("pooled", ITERATION),
	POOLED_LEGACY("pooled_legacy", ITERATION),
	PACKED("packed", ITERATION),
	PACKED_LEGACY("packed_legacy", ITERATION),
	CREATE_DELETE("insert_remove", INSERT_REMOVE),
	CREATE_DELETE_LEGACY("insert_remove_legacy", INSERT_REMOVE),
	ENTITY_EDIT("entity_edit", TRANSMUTE),
	ENTITY_EDIT_LEGACY("entity_edit_legacy", TRANSMUTE),
	ENTITY_TRANSMUTE("transmuter", TRANSMUTE),
	ENTITY_TRANSMUTE_LEGACY("transmuter_legacy", TRANSMUTE);


	public final String id;
	public final BenchmarkGroup group;
	
	BenchmarkType(String id, BenchmarkGroup group) {
		this.id = id;
		this.group = group;
	}
	
	public static BenchmarkType parse(String benchmark) {
		String id = benchmark.substring(benchmark.lastIndexOf('.') + 1);
		for (BenchmarkType bt : values()) {
			if (id.equals(bt.id))
				return bt;
		}
		
		throw new RuntimeException(format("No type identified by '%s'", benchmark));
	}
}