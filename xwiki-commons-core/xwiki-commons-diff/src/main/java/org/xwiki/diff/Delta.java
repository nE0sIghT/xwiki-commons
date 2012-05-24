/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.diff;

import java.util.List;

/**
 * A delta between two version of a list.
 * 
 * @param <E> the type of compared elements
 * @version $Id$
 */
public interface Delta<E>
{
    public enum TYPE
    {
        CHANGE,
        DELETE,
        INSERT
    }

    public abstract void verify(List<E> target) throws PatchException;

    public abstract void apply(List<E> target) throws PatchException;

    public abstract void restore(List<E> target);

    public abstract TYPE getType();

    public Chunk<E> getPrevious();

    public Chunk<E> getNext();
}
