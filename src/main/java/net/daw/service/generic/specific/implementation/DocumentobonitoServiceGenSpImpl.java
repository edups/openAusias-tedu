/*
 * Copyright (C) July 2014 Rafael Aznar
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.daw.service.generic.specific.implementation;

import net.daw.service.generic.implementation.TableServiceGenImpl;
import java.sql.Connection;
import javax.servlet.ServletException;
import net.daw.bean.generic.specific.implementation.DocumentobonitoBeanGenSpImpl;
import net.daw.dao.generic.specific.implementation.DocumentobonitoDaoGenSpImpl;
import net.daw.helper.statics.AppConfigurationHelper;

public class DocumentobonitoServiceGenSpImpl extends TableServiceGenImpl {

    public DocumentobonitoServiceGenSpImpl(String strObject, String pojo, Connection con) {
        super(strObject, pojo, con);
    }

    public String getContenido(Integer id) throws Exception {
        String data;
        try {
            DocumentobonitoBeanGenSpImpl oDocumentobonitoBean = new DocumentobonitoBeanGenSpImpl();
            oDocumentobonitoBean.setId(id);
            DocumentobonitoDaoGenSpImpl oDocumentobonitoDao = new DocumentobonitoDaoGenSpImpl(oConnection);
            oDocumentobonitoBean = oDocumentobonitoDao.get(oDocumentobonitoBean, AppConfigurationHelper.getJsonDepth());
            return "{\"data\":\"" + oDocumentobonitoBean.getContenido() + "\"}";
        } catch (Exception e) {
            throw new ServletException("GetContenido: View Error: " + e.getMessage());
        }
    }
}
