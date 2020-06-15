/**
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.tencent.tars.protocol.parse.ast;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TarsRoot extends CommonTree {

	public TarsRoot(int tokenType) {
		super(new CommonToken(tokenType));
	}

	private final List<TarsInclude> includeList = new ArrayList<TarsInclude>();
	private final List<TarsNamespace> namespaceList = new ArrayList<TarsNamespace>();

	@Override
	public void addChild(Tree child) {
		super.addChild(child);

		if (child instanceof TarsInclude) {
			includeList.add((TarsInclude) child);
		} else if (child instanceof TarsNamespace) {
			namespaceList.add((TarsNamespace) child);
		}
	}

	public List<TarsInclude> includeFileList() {
		return includeList;
	}

	public List<TarsNamespace> namespaceList() {
		return namespaceList;
	}

	/*
	 * just for print doc
	 */
	
	private CommonTokenStream tokenStream;

	public CommonTokenStream getTokenStream() {
		return tokenStream;
	}

	public void setTokenStream(CommonTokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}
	
}
