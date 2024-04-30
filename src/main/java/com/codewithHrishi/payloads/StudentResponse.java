package com.codewithHrishi.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
private List<StudentDto>list;
private int pageNum;
private int pageSize;
private int totalElements;
private boolean isLast;

}
