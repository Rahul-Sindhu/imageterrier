/**
 * ImageTerrier - The Terabyte Retriever for Images
 * Webpage: http://www.imageterrier.org/
 * Contact: jsh2@ecs.soton.ac.uk
 * Electronics and Computer Science, University of Southampton
 * http://www.ecs.soton.ac.uk/
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is CosineWeightingModel.java
 *
 * The Original Code is Copyright (C) 2011 the University of Southampton
 * and the original contributors.
 * All Rights Reserved.
 *
 * Contributor(s):
 *   Jonathon Hare <jsh2@ecs.soton.ac.uk> (original contributor)
 *   Sina Samangooei <ss@ecs.soton.ac.uk>
 *   David Dupplaw <dpd@ecs.soton.ac.uk>
 */
package org.imageterrier.models;

import org.terrier.matching.models.WeightingModel;

/**
 * A {@link WeightingModel} that calculates an unweighted
 * cosine distance between query and target vectors. 
 * 
 * @author Jonathon Hare <jsh2@ecs.soton.ac.uk>
 */
public class CosineWeightingModel extends WeightingModel {
	private static final long serialVersionUID = 1L;
	
	/** model name */
	private static final String name = "UNWEIGHTED_COSINE_DISTANCE";
	
	@Override
	public String getInfo() {
		return name;
	}

	@Override
	public double score(double tf, double docLength) {
		double dtf = tf/docLength;
		double qtf = keyFrequency * c; //Note: c must be set to correctly weight the query terms...
		
		double score = Math.abs(qtf - dtf) - qtf - dtf;
		return -1 * score;
	}

	@Override
	public double score(double tf, double docLength, double nT, double F_t, double keyFrequency) {
		throw new UnsupportedOperationException();
	}

}
