package common.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class EmfUtil {

	public static boolean doSaveBin (EObject o, String resFile, String extension) {

		// Register the XMI resource factory for the PDA extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		String EXT = extension.substring(1);
		m.put(EXT , new FooBinaryResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		URI fileURI = URI.createFileURI(new File(resFile+extension).getAbsolutePath());

		Resource resource = resSet.createResource(fileURI);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(o);

		// Now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
			return true ;
		} catch (IOException e) {
			e.printStackTrace() ;
			return false ;
		} catch (Exception e) {
			e.printStackTrace() ;
			return false ;
		}		
	}

	public static EObject doOpenBin(EObject myinstance, String resFile0, String extension) {
		String resFile = resFile0+extension;
		File file = new File(resFile);
		if (file.exists()) {
			myinstance.eClass() ;

			// Register the XMI resource factory for the PDA extension
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			String EXT = extension.substring(1);
			m.put(EXT, new FooBinaryResourceFactoryImpl());
			
			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();
			
			String path = file.getAbsolutePath();
			Resource resource ;
			try {
				// Get the resource
				resource = resSet.getResource(URI.createFileURI(path), true);
			}
			catch (Exception e) {
				e.printStackTrace() ;
				return null ;
			}		

			EObject obj = resource.getContents().get(0) ;
			return obj ;
		}
		else {
			return null ;
		}
	}

}

class FooBinaryResourceFactoryImpl implements Resource.Factory {
	public Resource createResource(URI uri) {
		return new FooBinaryResourceImpl(uri);
	}
};
class FooBinaryResourceImpl extends BinaryResourceImpl {
	public FooBinaryResourceImpl(URI uri) {
		super(uri);
	}
}
