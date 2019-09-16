/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.sql.parser.ddl;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.util.ImmutableNullableList;
import org.apache.flink.sql.parser.ExtendedSqlNode;

import java.util.List;

/**
 * CREATE FUNCTION DDL sql call.
 */
public class SqlCreateFunction extends SqlCreate implements ExtendedSqlNode {
	public static final SqlSpecialOperator OPERATOR = new SqlSpecialOperator("CREATE FUNCTION", SqlKind.CREATE_FUNCTION);

	private SqlNode functionName;

	private String className;

	/**
	 *
	 * @param pos
	 * @param functionName
	 * @param className FIXME use SqlLiteral data type
	 */
	public SqlCreateFunction(SqlParserPos pos, SqlNode functionName, String className) {
		super(OPERATOR, pos, false, false);
		this.functionName = functionName;
		this.className = className;
	}

	@Override
	public SqlOperator getOperator() {
		return OPERATOR;
	}

	@Override
	public List<SqlNode> getOperandList() {
		// FIXME
		return null;
	}

	public SqlNode getFunctionName() {
		return functionName;
	}

	public void setFunctionName(SqlNode functionName) {
		this.functionName = functionName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void unparse(
		SqlWriter writer,
		int leftPrec,
		int rightPrec) {
		writer.keyword("CREATE");
		writer.keyword("FUNCTION");
		functionName.unparse(writer, leftPrec, rightPrec);
		writer.keyword("AS");
		writer.print("'" + className + "'");
	}

	public void validate() {
		// FIXME
	}
}
