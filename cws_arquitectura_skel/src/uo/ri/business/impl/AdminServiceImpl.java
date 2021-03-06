package uo.ri.business.impl;

import java.util.List;

import uo.ri.business.AdminService;
import uo.ri.business.impl.admin.AddMechanic;
import uo.ri.business.impl.admin.DeleteMechanic;
import uo.ri.business.impl.admin.FindAllMechanics;
import uo.ri.business.impl.admin.FindMechanicById;
import uo.ri.business.impl.admin.UpdateMechanic;
import uo.ri.model.Mecanico;
import uo.ri.model.exception.BusinessException;

public class AdminServiceImpl implements AdminService 
{

	private CommandExecutor executor = new CommandExecutor();
	
	@Override
	public void newMechanic(Mecanico mecanico) throws BusinessException 
	{
		executor.execute(new AddMechanic( mecanico ));
	}

	@Override
	public void updateMechanic(Mecanico mecanico) throws BusinessException 
	{
		executor.execute(new UpdateMechanic( mecanico ));
	}

	@Override
	public void deleteMechanic(Long idMecanico) throws BusinessException 
	{
		executor.execute(new DeleteMechanic(idMecanico));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mecanico> findAllMechanics() throws BusinessException 
	{
		return (List<Mecanico>) executor.execute(new FindAllMechanics());
	}

	@Override
	public Mecanico findMechanicById(Long id) throws BusinessException 
	{
		return (Mecanico) executor.execute(new FindMechanicById(id));
	}

}
