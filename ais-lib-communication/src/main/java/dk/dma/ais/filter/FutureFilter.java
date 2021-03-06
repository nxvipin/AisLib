/* Copyright (c) 2011 Danish Maritime Authority.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dk.dma.ais.filter;

import dk.dma.ais.packet.AisPacket;

/**
 * The type Future filter.
 *
 * @author Jens Tuxen Reject packets with timestamp in the future according to device clock
 */
public class FutureFilter implements IPacketFilter {
    private final long threshold;

    /**
     * Instantiates a new Future filter.
     */
    public FutureFilter() {
        threshold = 60000;
    }

    /**
     * Instantiates a new Future filter.
     *
     * @param threshold the threshold
     */
    public FutureFilter(long threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean rejectedByFilter(AisPacket packet) {
        return packet.getBestTimestamp()+threshold > System.currentTimeMillis();
    }

}
